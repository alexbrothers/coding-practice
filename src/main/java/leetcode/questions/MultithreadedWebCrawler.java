package leetcode.questions;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MultithreadedWebCrawler {

    public interface HtmlParser {
        List<String> getUrls(String url);
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        queue.add(startUrl);
        HashSet<String> visited = new HashSet<>();
        Queue<Future<Boolean>> runningTasks = new LinkedList<>();
        List<String> result = new ArrayList<>();
        while (true) {
            if (!queue.isEmpty()) {
                String url = queue.poll();
                if (!visited.contains(url) && isSameHost(startUrl, url)) {
                    result.add(url);
                    visited.add(url);
                    try {
                        Future<Boolean> future = executorService.submit(new CrawlerWorker(queue, htmlParser, url));
                        runningTasks.offer(future);
                    } catch (Exception e) {
                        System.out.println("Exception: " + e.getMessage());
                        throw e;
                    }
                }
            }
            else {
                if (runningTasks.isEmpty()) {
                    break;
                }
                else {
                    try {
                        runningTasks.poll().get();
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("Interrupted");
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        executorService.shutdown();
        return result;
    }

    private boolean isSameHost(String startUrl, String currentUrl) {
        return getHost(startUrl).equals(getHost(currentUrl));
    }

    private String getHost(String url) {
        String converted = url.substring(7);
        String[] split = converted.split("/");
        if (split.length == 0) {
            return converted;
        }
        return split[0];
    }

    class CrawlerWorker implements Callable<Boolean> {

        private Queue<String> queue;
        private HtmlParser htmlParser;
        private String url;

        CrawlerWorker(Queue<String> queue, HtmlParser htmlParser, String url) {
            this.queue = queue;
            this.htmlParser = htmlParser;
            this.url = url;
        }


        @Override
        public Boolean call() throws Exception {
            List<String> urls = htmlParser.getUrls(url);
            for (int i = 0; i < urls.size(); i++) {
                queue.offer(urls.get(i));
            }
            return true;
        }
    }

}
