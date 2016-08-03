package com.disney.studios;

import com.disney.studios.domain.Dog;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.validation.OverridesAttribute;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class Utils {


	public static String encodeUrl(String url) {

		String encUrl = url;

		try {

			encUrl = URLEncoder.encode(url, "UTF-8");

		} catch (UnsupportedEncodingException e) {

			System.err.println(e);
		}

		return encUrl;

	}

	public static String decodeUrl(String url) {

		String decUrl = url;

		try {

			decUrl = URLEncoder.encode(url, "UTF-8");

		} catch (UnsupportedEncodingException e) {

			System.err.println(e);
		}

		return decUrl;
	}

	public static String jsonify(Object o) {

		ObjectMapper mapper = new ObjectMapper();
		String json;

		try {

			json = mapper.writeValueAsString(o);

		} catch (Exception e) {

			System.err.println(e);
			return jsonifyRes("Response could not be converted to json");
		}

		return json;


	}

	public static String jsonifyRes(String res) {

		return new jsonres(res).toString();
	}

}
	 class jsonres{
			private String message;

			jsonres(String str){
				this.message = str;
			}

			@Override
            public String toString(){
			    StringBuilder builder = new StringBuilder();
                builder.append("{ \"Response\" : \"");
                builder.append(this.message);
                builder.append("\" }");
                return builder.toString();
            }
	}
