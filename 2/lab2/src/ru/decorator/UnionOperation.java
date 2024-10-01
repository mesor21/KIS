package ru.decorator;

import javax.enterprise.inject.Default;
import java.util.HashSet;
import java.util.Set;

@Default
public class UnionOperation implements ISetOperation {

    @Override
    public Set<Integer> apply(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
}