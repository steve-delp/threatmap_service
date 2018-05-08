package RansomwareSiteService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RansomwareSite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String county;
	private String host;
	private String ip;
	private String url;
	private String malware;
	private Double lat;
	private Double lon;

	private RansomwareSite() { } // JPA only

	public RansomwareSite(String county, String ip, String host, String url, String malware, Double lat, Double lon) {
		super();
		this.county = county;
		this.host = host;
		this.ip = ip;
		this.url = url;
		this.malware = malware;
		this.lat = lat;
		this.lon = lon;
	}


	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMalware() {
		return malware;
	}

	public void setMalware(String malware) {
		this.malware = malware;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}
}
