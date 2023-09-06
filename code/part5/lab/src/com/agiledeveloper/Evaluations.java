package com.agiledeveloper;

public interface Evaluations {
  static EvaluationResult isAdult(EvaluationResult partialResult) {
    if(partialResult.applicant.getAge() < 18) {
      return new EvaluationResult(partialResult.applicant, false,
        partialResult.details + "Applicant is not an adult.");
    }

    return new EvaluationResult(partialResult.applicant, partialResult.status, partialResult.details);
  }

  static EvaluationResult isSeniorDeveloper(EvaluationResult partialResult) {
    if(partialResult.applicant.getYearsOfExperience() < 10) {
      return new EvaluationResult(partialResult.applicant, false,
        partialResult.details + "Applicant is not a senior developer.");
    }

    return new EvaluationResult(partialResult.applicant, partialResult.status, partialResult.details);
  }

//  static EvaluationResult hasCollegeDegree(EvaluationResult partialResult) {
//  }
}
