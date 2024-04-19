package pe.edu.upao.alozanoc.arquitecturaapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired SmtpService smtpService;
}
