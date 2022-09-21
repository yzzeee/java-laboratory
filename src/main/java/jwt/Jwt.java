package jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

public class Jwt {

    static String jwtKey = "hello-jwt";

    public static void main(String[] args) {
        String token1 = createToken("test");
        System.out.println("token > " + token1);

        Claims claims1 = getClaimsFromToken(token1);
        System.out.println("claims1 > " + claims1);

        String token2 = createToken2("test");
        System.out.println("token > " + token2);

        Claims claims2 = getClaimsFromToken(token2);
        System.out.println("claims2 > " + claims2);

        Claims claims3 = getClaimsFromToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJzZWNsb3VkaXQtYWRtaW4iLCJleHAiOjE2NjM4Mzg2MTR9.i006KhSWJ7GfG04sp58_wpQzEiybQnXoJjvMfCtxHbo");
        System.out.println("claims3 > " + claims3);
    }

    public static String createToken(String userId) {
        Date now = new Date();
        Claims claims = Jwts.claims().setExpiration(new Date(now.getTime() + 60 * 1000L));
        claims.put("userId", userId);

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(jwtKey.getBytes()))
                .setClaims(claims)
                .compact();
    }

    public static String createToken2(String userId) {
        Claims claims = Jwts.claims().setSubject(userId);
        claims.put("userId", userId);
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(new Date().getTime() + 5 * 60 * 1000L))
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(jwtKey.getBytes()))
                .compact();
    }

    public static Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(jwtKey.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
    }
}
