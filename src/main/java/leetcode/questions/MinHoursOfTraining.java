package leetcode.questions;

public class MinHoursOfTraining {

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        return energyTrainingHours(initialEnergy, energy) + experienceTrainingHours(initialExperience, experience);
    }

    private int experienceTrainingHours(int initialExperience, int[] experience) {
        int hoursNeeded = 0;
        int current = initialExperience;
        for (int i = 0; i < experience.length; i++) {
            if (current <= experience[i]) {
                int diff = experience[i] - current + 1;
                hoursNeeded += diff;
                current += diff;
            }
            current += experience[i];
        }
        return hoursNeeded;
    }

    private int energyTrainingHours(int initialEnergy, int[] energy) {
        int hoursNeeded = 0;
        int current = initialEnergy;
        for (int i = 0; i < energy.length; i++) {
            if (current <= energy[i]) {
                int diff = energy[i] - current + 1;
                hoursNeeded += diff;
                current += diff;
            }
            current -= energy[i];
        }
        return hoursNeeded;
    }

}
