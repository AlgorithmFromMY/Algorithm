package p1033;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CockTail {
    private final int num;
    private int[] groups;
    private Material[] materials;

    public CockTail(int num) {
        this.num = num;
        initGroups();
        initMaterials();
    }

    public void addRatio(int a, int b, int p, int q) {
        long materialA = materials[a].quantity();
        long materialB = materials[b].quantity();
        int groupA = groups[a];
        int groupB = groups[b];

        multipleSameGroup(groupA, materialB * p);
        multipleSameGroup(groupB, materialA * q);
        unionGroup(groupA, groupB);
    }

    public List<Long> getQuantities() {
        divideCommonMeasure();

        return quantities();
    }

    private void initGroups(){
        groups = new int[num];
        for(int i = 0; i < num; i++)
            groups[i] = i;
    }

    private void initMaterials(){
        materials = new Material[num];

        for(int i = 0; i < num; i++)
            materials[i] = new Material();
    }

    private void multipleSameGroup(int group, long value){
        IntStream.range(0, num).filter(i -> groups[i] == group).forEach(i -> materials[i].multiple(value));
    }

    private void unionGroup(int a, int b){
        IntStream.range(0, num).filter(i -> groups[i] == a).forEach(i -> groups[i] = b);
    }

    private void divideCommonMeasure() {
        int[] primeMeasure = {2, 3, 5, 7};

        for(int measure : primeMeasure){
            long count = minCountFactorForMaterials(measure);
            divideFactorMultiple(measure, count);
        }
    }

    private long minCountFactorForMaterials(int factor) {
        return Arrays.stream(materials).map(Material::factors).map(
                factors -> factors.stream().filter(a -> a == factor).count()
        ).min(Long::compareTo).get();
    }

    private void divideFactorMultiple(int factor, long count) {
        Arrays.stream(materials).parallel().forEach(
                m -> LongStream.range(0,count).forEach(a -> m.divide(factor))
        );
    }

    private List<Long> quantities() {
        return Arrays.stream(materials).map(Material::quantity).collect(Collectors.toList());
    }
}