public class RunWeb {

	// The program can be invoked with command-line arguments
	//
	// If called like this:
	//      WebCrawler -N=50 -M=5 http://www.csc.uvic.ca
	// then the top 5 out of 50 websites visited in a breadth-first traversal
	// starting at the supplied URL are printed.
	//
	// If called like this:
	//      WebCrawler -test http://www.csc.uvic.ca
	// then the HTML text of the website at the specified URL is printed.
	public static void main(String[] args) {
		String url = null;
		int N = 0;
		int M = 0;
		boolean test = false;

		for(String s:args) {
			if (s.startsWith("-")) {
				if (s.equals("-test"))
					test = true;
				else if (s.startsWith("-N=") || s.startsWith("-n="))
					N = Integer.parseInt(s.substring(3));
				else if (s.startsWith("-M=") || s.startsWith("-m="))
					M = Integer.parseInt(s.substring(3));
				else
					System.out.println("** unrecognized option "+ s);
			} else
				url = s;
		}

		// Now supply defaults for any missing values
		if (url == null)
			url = "http://www.csc.uvic.ca";  // the default starting URL
		if (N <= 0)
			N = 20;	// the default number of sites to count
		if (M <= 0)
			M = 10; // the default number of sites to print

		WebCrawler wc = new WebCrawler(N);


		if (test) {
			System.out.println("Here");
			// it's a test run to try out the GetPage method
			String webpage = wc.getPage(url);
			System.out.println("web page =\n" +webpage+"\n");
		} else {
			// it's a production run of the program
			wc.Crawl(url);
			wc.PrintTopSites(M);
		}
	}
}