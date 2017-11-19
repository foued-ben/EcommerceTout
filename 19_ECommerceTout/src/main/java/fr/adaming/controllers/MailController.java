package fr.adaming.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@Controller
@Scope("session")
public class MailController {
	private IClientService clientService;

	@RequestMapping(value = "/mail", method = RequestMethod.GET)
	public String afficheMail(Model modele) {
		modele.addAttribute("client", new Client());

		return "mail";
	}

	@RequestMapping(value = "/envoyer", method = RequestMethod.POST)
	public String envoyerMail(@Valid Client client, BindingResult br) {
		if (br.hasErrors()) {
			return "mail";
		}
		Client clOut = clientService.addClient(client);
		if (clOut != null) {
			final String username = "projet.ecommerce@gmx.fr";
			final String password = "projetEcommerce3";
			Properties props = new Properties();

			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmx.com");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.ssl.trust", "*");
			Session session = Session.getInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(clOut.getEmail()));
				message.setSubject("Commande Ecommerce");
				StringBuilder sb = new StringBuilder();
				sb.append("Mme/Mr. " + clOut.getNom() + ",\n\n");
				sb.append("Vous avez passé une commande pour :\n");
				String[] items = { "item 1", "item 2", "item 3" };// Changer
				for (int i = 0; i < items.length; i++) {
					sb.append("  - " + items[i] + "\n");
				}
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.add(Calendar.DAY_OF_YEAR, 12);
				sb.append("\nLa date de réception est prévue au "
						+ calendar.getTime());
				message.setText(sb.toString());
				Transport.send(message);
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
		}
		return "accueil";
	}

}
