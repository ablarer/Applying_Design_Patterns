package com.agiledeveloper;

public class EvaluationResult {
  public final Person applicant;
  public final boolean status;
  public final String details;

  public EvaluationResult(Person applicant, boolean status, String details) {
    this.applicant = applicant;
    this.status = status;
    this.details = details;
  }
}
