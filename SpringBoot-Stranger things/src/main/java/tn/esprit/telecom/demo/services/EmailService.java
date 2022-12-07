package tn.esprit.telecom.demo.services;

import javax.mail.MessagingException;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);

    void sendMessageWithAttachmentEtudiant(String to, String subject, String text, String pathToAttachment) throws MessagingException;
    void sendMessageWithAttachmentEquipe(String to, String subject, String text, String pathToAttachment) throws MessagingException;

}
