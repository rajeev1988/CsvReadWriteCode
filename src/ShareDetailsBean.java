import java.util.List;

public class ShareDetailsBean
{
	private String year;
	private String month;
	private List<ShareBean> shareList = null;

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	public String getMonth()
	{
		return month;
	}

	public void setMonth(String month)
	{
		this.month = month;
	}

	public List<ShareBean> getShareList()
	{
		return shareList;
	}

	public void setShareList(List<ShareBean> shareList)
	{
		this.shareList = shareList;
	}
}