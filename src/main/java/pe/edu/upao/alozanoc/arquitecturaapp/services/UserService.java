package pe.edu.upao.alozanoc.arquitecturaapp.services;

public class UserService {

    /**
     * Revisa que el password tenga al menos un simbolo, una mayúscula
     * Y que sea mayor que 6 caracteres
     * @param password
     * @return
     */
    public static boolean checkIfPaswordIsValid(String password) {
        if (password == null) return false;
        return password.matches(".*[A-Z].*") && password.length() >= 6 && password.matches(".*[^A-Za-z].*");
    }
}
