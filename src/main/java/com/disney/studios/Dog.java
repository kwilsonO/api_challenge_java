package com.disney.studios;

public class Dog implements Comparable<Dog> {

	private final String url;
	private String enc_url;
	private final String breed;
	private int favCount = 0;
	private int upCount = 0;
	private int downCount = 0;
	private int voteTotal = 0;

	public Dog(String url, String breed){
		this.url = url;
		this.enc_url = Utils.encodeUrl(url);
		this.breed = breed;
	}


	public void favorite(){
		this.favCount++;
	}

	public int getFavCount(){
		return this.favCount;
	}

	public void upvote(){

		this.upCount++;
		this.voteTotal++;
	}

	public int getUpCount(){
		return this.upCount;
	}

	public void downvote(){
		this.downCount++;
		this.voteTotal--;
	}

	public int getDownCount(){
		return this.downCount;
	}

	public int getVoteTotal(){
		return this.voteTotal;	
	}

	public String toString(){
		String out = "Url: " + this.url
		         + "\nEncUrl: " + this.enc_url
			 + "\nFavCount: " + this.favCount
			 + "\nUpCount: " + this.upCount
			 + "\nDownCount: " + this.downCount
			 + "\nVoteTotal: " + this.voteTotal
			 + "\n";
		return out;
	}

	@Override
	public int compareTo( final Dog o ) {
		return Integer.compare(this.favCount, o.favCount);
	}
}
