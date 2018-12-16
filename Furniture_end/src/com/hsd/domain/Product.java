package com.hsd.domain;
/**
 * 
 * CREATE TABLE `product` (
  `pid` varchar(50) NOT NULL,
  `pname` varchar(100) DEFAULT NULL,
  `pprice` double DEFAULT NULL,
  `pdesc` varchar(300) DEFAULT NULL,
  `pcolor` varchar(20) DEFAULT NULL,
  `psize` varchar(10) DEFAULT NULL,
  `pimage` varchar(64) DEFAULT NULL,
  `is_featured` int(4) DEFAULT NULL,
  `is_special` int(4) DEFAULT NULL,
  `availiable` int(4) DEFAULT NULL,
  `cid` varchar(64) DEFAULT NULL,
  `sid` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `sfk_0001` (`sid`),
  KEY `sfk_0002` (`cid`),
  CONSTRAINT `sfk_0001` FOREIGN KEY (`sid`) REFERENCES `style` (`sid`),
  CONSTRAINT `sfk_0002` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 *
 */
public class Product {
	private String pid;
	private String pname;
	private double pprice;
	private String pdesc;
	private String pcolor;
	private String psize;
	private String pimage;
	private int is_featured;
	private int is_special;
	private int availiable;
	private String cid;
	private String sid;
	
	public Product() {
		
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPprice() {
		return pprice;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPcolor() {
		return pcolor;
	}

	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	public String getPsize() {
		return psize;
	}

	public void setPsize(String psize) {
		this.psize = psize;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public int getIs_featured() {
		return is_featured;
	}

	public void setIs_featured(int is_featured) {
		this.is_featured = is_featured;
	}

	public int getIs_special() {
		return is_special;
	}

	public void setIs_special(int is_special) {
		this.is_special = is_special;
	}

	public int getAvailiable() {
		return availiable;
	}

	public void setAvailiable(int availiable) {
		this.availiable = availiable;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
	
}
