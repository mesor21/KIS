package ru.decorator;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.Set;

@Dependent
public class SetOperationBean {
    @Inject
    private ISetOperation setOperation;

    public Set<Integer> performOperation(Set<Integer> set1, Set<Integer> set2) {
        return setOperation.apply(set1, set2);
    }
}