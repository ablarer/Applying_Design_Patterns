package com.agiledeveloper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EvaluateApplicantTest {
  Person applicant1;
  Person applicant2;
  Person applicant3;

  @BeforeEach
  void init() {
    applicant1 = new Person("Pat", 17, 3, false);
    applicant2 = new Person("Sam", 27, 10, false);
    applicant3 = new Person("Sara", 37, 20, true);
  }

  @Test
  void canary() {
    assertTrue(true);
  }

  @Test
  void applicantPassesEvaluationWithNoCriteria() {
    EvaluationResult evaluationResult = Evaluator.evaluate(applicant1);

    assertTrue(evaluationResult.status);
    assertEquals("", evaluationResult.details);
  }

  @Test
  void applicantFailsAdultCriteria(){
    EvaluationResult evaluationResult =
      Evaluator.evaluate(applicant1, Evaluations::isAdult);

    assertFalse(evaluationResult.status);
    assertEquals("Applicant is not an adult.", evaluationResult.details);
  }

  @Test
  void applicantPassesAdultCriteria(){
    EvaluationResult evaluationResult =
      Evaluator.evaluate(applicant2, Evaluations::isAdult);

    assertTrue(evaluationResult.status);
    assertEquals("", evaluationResult.details);
  }

  @Test
  void applicantFailsSeniorDeveloper(){
    EvaluationResult evaluationResult =
      Evaluator.evaluate(applicant1, Evaluations::isSeniorDeveloper);

    assertFalse(evaluationResult.status);
    assertEquals("Applicant is not a senior developer.", evaluationResult.details);
  }

  @Test
  void applicantPassesSeniorDeveloper(){
    EvaluationResult evaluationResult =
      Evaluator.evaluate(applicant2, Evaluations::isSeniorDeveloper);

    assertTrue(evaluationResult.status);
    assertEquals("", evaluationResult.details);
  }

  @Test
  void applicantFailsHasDegree(){
    EvaluationResult evaluationResult =
      Evaluator.evaluate(applicant2, Evaluations::hasCollegeDegree);

    assertFalse(evaluationResult.status);
    assertEquals("Applicant does not have a degree.", evaluationResult.details);
  }

  @Test
  void applicantPassesHasDegree(){
    EvaluationResult evaluationResult =
      Evaluator.evaluate(applicant3, Evaluations::hasCollegeDegree);

    assertTrue(evaluationResult.status);
    assertEquals("", evaluationResult.details);
  }

  @Test
  void applicantPassesAdultAndSeniorDeveloper() {
    EvaluationResult evaluationResult =
      Evaluator.evaluate(applicant2, Evaluations::isAdult, Evaluations::isSeniorDeveloper);

    assertTrue(evaluationResult.status);
    assertEquals("", evaluationResult.details);
  }

  @Test
  void applicantPassesAdultSeniorDeveloperAndDegreeHolder() {
    EvaluationResult evaluationResult =
      Evaluator.evaluate(applicant3, Evaluations::isAdult, Evaluations::isSeniorDeveloper, Evaluations::hasCollegeDegree);

    assertTrue(evaluationResult.status);
    assertEquals("", evaluationResult.details);
  }

  @Test
  void applicantFailsAllOfAdultSeniorDeveloperAndDegreeHolder() {
    EvaluationResult evaluationResult =
      Evaluator.evaluate(applicant1, Evaluations::isAdult, Evaluations::isSeniorDeveloper, Evaluations::hasCollegeDegree);

    assertFalse(evaluationResult.status);
    assertEquals("Applicant is not an adult.Applicant is not a senior developer.Applicant does not have a degree.", evaluationResult.details);
  }

  @Test
  void applicantFailsOneOfAdultSeniorDeveloperAndDegreeHolder() {
    EvaluationResult evaluationResult =
      Evaluator.evaluate(applicant2, Evaluations::isAdult, Evaluations::isSeniorDeveloper, Evaluations::hasCollegeDegree);

    assertFalse(evaluationResult.status);
    assertEquals("Applicant does not have a degree.", evaluationResult.details);
  }
}
