package com.groupb.cuiz.web.quiz;

import java.util.List;

public class SampleRunResult {
    private List<String> exOutputs;
    private List<String> qOutputs;

    private SampleRunResult(List<String> exOutputs, List<String> qOutputs) {
        this.exOutputs = exOutputs;
        this.qOutputs = qOutputs;
    }

    public static SampleRunResult createResult(List<String> exOutputs, List<String> qOutputs) {
        return new SampleRunResult(exOutputs, qOutputs);
    }

    public List<String> getExOutputs() {
        return exOutputs;
    }

    public List<String> getqOutputs() {
        return qOutputs;
    }
}
