package com.disney.studios;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class Utils{


	public static String encodeUrl(String url){

		String encUrl = url;

		try{

			encUrl = URLEncoder.encode(url, "UTF-8");

		}catch(UnsupportedEncodingException e){

			System.err.println(e);
		}

		return encUrl;

	}

	public static String decodeUrl(String url){

		String decUrl = url;

		try{

			decUrl = URLEncoder.encode(url, "UTF-8");

		}catch(UnsupportedEncodingException e){

			System.err.println(e);
		}

		return decUrl;


	}
}
