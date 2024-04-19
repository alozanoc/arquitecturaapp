package pe.edu.upao.alozanoc.arquitecturaapp.serializers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequest {
    String username;
    String password;
}
