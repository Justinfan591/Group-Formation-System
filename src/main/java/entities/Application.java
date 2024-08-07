package entities;

/**
 * Represents an application entity with details about a user application for a project.
 */
public class Application implements ApplicationInterface {
    private int senderUserId;
    private int projectId;
    private String text;
    private byte[] pdfBytes;

    /**
     * Constructs an Application object with the specified details.
     *
     * @param senderUserId the ID of the user sending the application.
     * @param projectId the ID of the project for which the application is made.
     * @param text the text content of the application.
     * @param pdfBytes the PDF file as a byte array.
     */
    public Application(int senderUserId, int projectId, String text, byte[] pdfBytes) {
        this.senderUserId = senderUserId;
        this.projectId = projectId;
        this.text = text;
        this.pdfBytes = pdfBytes;
    }

    /**
     * Gets the sender's user ID.
     *
     * @return the sender's user ID.
     */
    public int getSenderUserId() {
        return this.senderUserId;
    }

    /**
     * Sets the sender's user ID.
     *
     * @param senderUserId the sender's user ID.
     */
    public void setSenderUserId(int senderUserId) {
        this.senderUserId = senderUserId;
    }

    /**
     * Gets the project ID.
     *
     * @return the project ID.
     */
    public int getProjectId() {
        return this.projectId;
    }

    /**
     * Sets the project ID.
     *
     * @param projectId the project ID.
     */
    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    /**
     * Gets the text content of the application.
     *
     * @return the text content of the application.
     */
    public String getText() {
        return this.text;
    }

    /**
     * Sets the text content of the application.
     *
     * @param text the text content of the application.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the PDF file as a byte array.
     *
     * @return the PDF file as a byte array.
     */
    public byte[] getPdfBytes() {
        return this.pdfBytes;
    }

    /**
     * Sets the PDF file as a byte array.
     *
     * @param pdfBytes the PDF file as a byte array.
     */
    public void setPdfBytes(byte[] pdfBytes) {
        this.pdfBytes = pdfBytes;
    }
}
