package com.skr.edge.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.skr.edge.demo.model.CustomNumberEntity;
import com.skr.edge.demo.util.FastestComparator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class NumberFinderImplementation implements NumberFinder {

    /**
     * {@inheritDoc}
     */
    public boolean contains(final int valueToFind, List<CustomNumberEntity> list) {
        /**
         * Parallel stream is used here to ensure the compare method is executed in parallel given the number of cores is supported
         * for parallel computing.
         * This is used keeping in mind of the possible large file processing.
         * worst time complexity is O(n log n)
         *
         * I have also added a commented section of the code in the bottom of the class to show my thought processes
         */
        final FastestComparator fastestComparator = new FastestComparator();
        boolean found;
        found = list.parallelStream()
                .filter(customNumberEntity -> customNumberEntity.getNumber() !=null)
                .filter(customNumberEntity -> customNumberEntity.getNumber().matches("[1-9][0-9]*|0"))
                .anyMatch(customNumberEntity -> fastestComparator.compare(valueToFind, customNumberEntity) == 0);
        return found;
    }

    /**
     * {@inheritDoc}
     */
    public List<CustomNumberEntity> readFromFile(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CustomNumberEntity> customNumberEntityList =  null;
        try {
            customNumberEntityList = objectMapper.readValue(new File(filePath), new TypeReference<List<CustomNumberEntity>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customNumberEntityList;
    }

   /* private void sample() {
        *//**
         * This can be solved only by linear search where the worst time complexity is O(n).
         * However instead of moving through the list from start to finish, we are comparing the first and the last value simultaneously
         * By doing this, we can safely say that the worst time complexity O(n) would be achieved only if and only
         * if the value to be searched is in the middle or nearing towards middle
         * else it would be o(n-k) where k is the no of times the comparator is used.
         * We can check the middle first and then move on to the iteration so that at the start but if the value to be searched is at
         * middle+1 index, the worst complexity would still be the same
         *
         * This method is used since no sorting techniques to be used as mentioned in the requirement.
         *
         *//*
        FastestComparator fastestComparator = new FastestComparator();
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            if (list.get(start) == null || list.get(start).getNumber() == null  || (! list.get(start).getNumber().matches("[1-9][0-9]*|0"))) {
                start = start + 1;
            } else if (list.get(end) == null || list.get(end).getNumber() == null || (! list.get(end).getNumber().matches("[1-9][0-9]*|0"))) {
                end = end - 1;
            } else if ((fastestComparator.compare(valueToFind, list.get(start)) == 0) || (fastestComparator.compare(valueToFind, list.get(end)) == 0)) {
                return true;
            } else {
                start = start + 1;
                end = end - 1;
            }
        }
        return false;
    }*/
}