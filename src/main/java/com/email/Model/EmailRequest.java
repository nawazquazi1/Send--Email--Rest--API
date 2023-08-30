package com.email.Model;

/**
 * @author im_na
 */
public class EmailRequest {
    private String to;
    private String subject;
    private String message;

    @Override
    public String toString() {
        return "EmailRequest{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public EmailRequest(String from, String subject, String message) {
        this.to = from;
        this.subject = subject;
        this.message = message;
    }

    private EmailRequest() {

    }

    /**
     * get field
     *
     * @return to
     */
    public String getTo() {
        return this.to;
    }

    /**
     * set field
     *
     * @param to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * get field
     *
     * @return subject
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     * set field
     *
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * get field
     *
     * @return message
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * set field
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
