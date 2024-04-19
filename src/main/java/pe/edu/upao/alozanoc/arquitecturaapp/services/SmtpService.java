package pe.edu.upao.alozanoc.arquitecturaapp.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmtpService {
    @Value("${mail.server}")
    String smtpServer;
}
