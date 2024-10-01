package ru.decorator;

import java.util.Set;

public interface ISetOperation {
    Set<Integer> apply(Set<Integer> set1, Set<Integer> set2);
}