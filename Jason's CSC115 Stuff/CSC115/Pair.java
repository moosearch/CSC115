public class Pair {

	private String url;
	private int occurrences;  // number of times the url has been referenced so far

	public Pair( String url ) {
		this.url = url;
		this.occurrences = 1;
	}

	public String getUrl(){
		return this.url;
	}

	public int getOccurrences(){
		return this.occurrences;
	}

	public void setUrl(String url){
			this.url = url;
		}

	public void setOccurrences(int occurr){
			this.occurrences = occurr;
	}

}