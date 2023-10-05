package tråde.flette;

import tråde.flette.FletteSortering;

import java.util.List;

public class SortThreads extends Thread {
    private List<Integer> list;
    private int begin;
    private int end;
    private FletteSortering fletteSortering;

    public SortThreads(List<Integer> list, int begin, int end, FletteSortering fletteSortering) {
        this.list = list;
        this.begin = begin;
        this.end = end;
        this.fletteSortering = fletteSortering;
    }

    @Override
    public void run() {
        fletteSortering.mergesort(list, begin, end);
    }
}