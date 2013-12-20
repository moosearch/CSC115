import java.io.*;
import java.net.URL;
import java.util.*;

public class WebCrawler {

	Pair[] Visit;

	private int count;  // number of elements used in the Visit array

	Queue<String> WorkList;

	// N is the maximum number of websites to visit before stopping
	public WebCrawler(int N) {
		Visit = new Pair[N];
		//System.out.println(Visit[0]);
		count = 0;
		WorkList = new Queue<String>();
	}

	public String getPage( String url ) {
        try {
            BufferedReader br = new BufferedReader(
				new InputStreamReader(new URL(url).openStream()));
                StringBuffer sb = new StringBuffer();
                for( ; ; ) {
                    String line = br.readLine();
                    if (line == null) break;
                    sb.append(line);
                    sb.append("\n");
                }
                return sb.toString();
            } catch( Exception e ) {
        	return null;
        }
	}

	// Beginning with the starting URL, visit websites adding them to the
	// Visit array if not there already.
	// The visit strategy described in Assignment 3 MUST be followed,
	// otherwise there is danger of non-terminating loops.
	public void Crawl(String startingURL) {
		Pair n = new Pair(startingURL);
		Visit[count++] = n;
		WorkList.enqueue(startingURL);
		while(!WorkList.isEmpty()) {
			if(getPage(startingURL) != null) {
				findPage(WorkList.dequeue());
			}
		}
	}

	//finds any pages or links to other pages
	public void findPage(String website) {
		String temp = "";
		int begin = 0;
		int end = 0;

		while(begin != -1) {
			begin = getPage(website).indexOf(" href=\"http://", begin);
			if(count > Visit.length) {
				break;
			}

			if(begin == -1) {
				break;
			} else {
				begin += 7;
				end = getPage(website).indexOf("\"", begin + 14);
				temp = getPage(website).substring(begin, end);
				checkPage(temp);
			}
		}
	}

	//checks page for how many times the website has been linked
	public void checkPage(String website) {
		boolean check = false;
		for(int i = 0; i < count; i++) {
			if(Visit[i].getUrl().equals(website)) {
				check = true;
				Visit[i].setOccurrences(Visit[i].getOccurrences() + 1);
			}
		}

		if(check == false) {
			Pair x = new Pair(website);
			Visit[count++] = x;
			WorkList.enqueue(website);
		}
	}

	public void BubbleSort() {
		boolean sort = true;
		while(sort) {
			sort = false;
			for(int i = count - 1; i > 0; i--) {
				if(Visit[i].getOccurrences() > Visit[i-1].getOccurrences()) {
					Pair temp = Visit[i];
					Visit[i] = Visit[i-1];
					Visit[i-1] = temp;
					sort = true;
				}
			}

			if(!sort) {
				break;
			}
		}
	}

	// Outputs the web addresses (URLs) and counts for the m most popular
	// websites in the Visit array.
	public void PrintTopSites( int m ) {
		BubbleSort();
		if(m > count) {
			for(int i = 0; i < count; i++) {
				System.out.println(Visit[i].getUrl() + " " + Visit[i].getOccurrences() + " Occurrences");
			}
		} else{
			for(int j = 0; j < m; j++) {
				System.out.println(Visit[j].getUrl() + " " + Visit[j].getOccurrences() + " Occurrences");
			}
		}
	}
}
