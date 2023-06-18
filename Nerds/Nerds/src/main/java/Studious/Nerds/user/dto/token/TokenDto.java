package Studious.Nerds.user.dto.token;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    private String grantType;
    private String accessToken;
    private String refreshToken;
    private int refreshExpire;
    private String userEmail;
}
