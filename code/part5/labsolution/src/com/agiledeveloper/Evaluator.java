package com.agiledeveloper;

import java.util.function.Function;
import java.util.stream.Stream;

public interface Evaluator {
  static EvaluationResult evaluate(Person applicant, Function<EvaluationResult, EvaluationResult>...evaluations) {
    return Stream.of(evaluations)
      .reduce(Function.identity(), Function::andThen)
      .apply(new EvaluationResult(applicant, true, ""));
  }
}
