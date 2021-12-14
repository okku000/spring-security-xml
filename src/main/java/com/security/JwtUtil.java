package com.security;

import java.security.Key;

import org.springframework.stereotype.Component;

import com.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	private static final String TOKEN_base64 = "ZmQ0ZGI5NjQ0MDQwY2I4MjMxY2Y3ZmI3MjdhN2ZmMjNhODViOTg1ZGE0NTBjMGM4NDA5NzYxMjdjOWMwYWRmZTBlZjlhNGY3ZTg4Y2U3YTE1ODVkZDU5Y2Y3OGYwZWE1NzUzNWQ2YjFjZDc0NGMxZWU2MmQ3MjY1NzJmNTE0MzI";
	private Key key;

	public JwtUtil() {
		byte[] keyBytes = Decoders.BASE64.decode(TOKEN_base64);
		this.key = Keys.hmacShaKeyFor(keyBytes);
	}

	public User parseToken(String token) {
		try {
			Claims body = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();

			User u = new User();
			u.setName(body.getSubject());
			u.setId(Integer.parseInt((String) body.get("userId")));

			return u;
		} catch (JwtException | ClassCastException e) {
			return null;
		}
	}

	public String generateToken(User u) {
		Claims claims = Jwts.claims().setSubject(u.getName());
		claims.put("userId", u.getId() + "");

		return Jwts.builder().setClaims(claims).signWith(key).compact();
	}
}
