package p1644;

import java.util.List;
import java.util.Objects;

public class PrimeList {
    private int prefix;
    private int suffix;

    private final List<Integer> list;

    public PrimeList(List<Integer> list) {
        this.prefix = 0;
        this.suffix = 0;
        this.list = list;
    }

    public int popSuffix(){
        return list.get(++suffix);
    }

    public int popPrefix(){
        return list.get(prefix++);
    }

    public int getSuffix(){
        return list.get(suffix);
    }

    public int getPrefix(){
        return list.get(prefix);
    }

    public boolean isPrefixAndSuffixSame(){
        return prefix == suffix;
    }

    public boolean isNoMoreSuffixElement(){
        return suffix == list.size() - 1;
    }

    @Override
    public String toString() {
        return "PrimeList{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrimeList primeList = (PrimeList) o;
        return Objects.equals(list, primeList.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }
}
