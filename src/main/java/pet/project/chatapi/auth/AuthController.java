package pet.project.chatapi.auth;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pet.project.chatapi.auth.dto.SuccessfulAuthResponse;
import pet.project.chatapi.auth.dto.UserAuthorization;
import pet.project.chatapi.auth.dto.UserRegistration;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Authorization with email and password")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful email"),
            @ApiResponse(responseCode = "400", description = "Incorrect data"),
            @ApiResponse(responseCode = "401", description = "Unauthorized")
    })
    @PostMapping("/signin")
    public ResponseEntity<SuccessfulAuthResponse> signin(@Valid
                                                         @RequestBody
                                                         UserAuthorization userAuth) {
        SuccessfulAuthResponse authResponse = authService.authorization(userAuth);
        return ResponseEntity.ok(authResponse);
    }

    @Operation(summary = "User registration")
    @PostMapping("/signup")
    public ResponseEntity<SuccessfulAuthResponse> signup(@Valid
                                                         @RequestBody
                                                         UserRegistration userRegistration
    ) {
        SuccessfulAuthResponse authResponse = authService.registration(userRegistration);
        return ResponseEntity.ok(authResponse);
    }
}
