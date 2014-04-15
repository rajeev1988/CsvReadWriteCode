import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.csvreader.CsvReader;

public class CsvReaderExample
{
	public static void main(String[] args)
	{
		// Year,Month,Company A,Company B,Company C,Company D,Company E,Company F,Company G,Company H
		List<ShareDetailsBean> shareDetailsBean = new ArrayList<ShareDetailsBean>();

		try
		{
			CsvReader products = new CsvReader("/home/rajeev/users.csv");
			products.readHeaders();

			while (products.readRecord())
			{
				ShareDetailsBean bean = new ShareDetailsBean();
				bean.setYear(products.get("Year"));
				bean.setMonth(products.get("Month"));

				List<ShareBean> stri = new ArrayList<ShareBean>();

				ShareBean sh = new ShareBean();
				sh.setCompanyName("Company A");
				sh.setShare(products.get("Company A"));
				stri.add(sh);

				ShareBean sh1 = new ShareBean();
				sh1.setCompanyName("Company B");
				sh1.setShare(products.get("Company B"));
				stri.add(sh1);

				ShareBean sh2 = new ShareBean();
				sh2.setCompanyName("Company C");
				sh2.setShare(products.get("Company C"));
				stri.add(sh2);

				ShareBean sh3 = new ShareBean();
				sh3.setCompanyName("Company D");
				sh3.setShare(products.get("Company E"));
				stri.add(sh3);

				ShareBean sh4 = new ShareBean();
				sh4.setCompanyName("Company F");
				sh4.setShare(products.get("Company F"));
				stri.add(sh4);

				ShareBean sh5 = new ShareBean();
				sh5.setCompanyName("Company G");
				sh5.setShare(products.get("Company H"));
				stri.add(sh5);

				ShareBean sh6 = new ShareBean();
				sh6.setCompanyName("Company H");
				sh6.setShare(products.get("Company H"));
				stri.add(sh4);
				bean.setShareList(stri);
				shareDetailsBean.add(bean);
			}

			products.close();

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		Collections.sort(shareDetailsBean, new Comparator<ShareDetailsBean>()
		{
			public int compare(ShareDetailsBean o1, ShareDetailsBean o2)
			{
				return o2.getYear().compareTo(o1.getYear());
			}
		});

		for (ShareDetailsBean shared : shareDetailsBean)
		{

			System.out.println(shared.getYear());
			System.out.println(shared.getMonth());

			Collections.sort(shared.getShareList(), new Comparator<ShareBean>()
			{
				public int compare(ShareBean o1, ShareBean o2)
				{
					return o2.getShare().compareTo(o1.getShare());
				}
			});

			for (ShareBean sd : shared.getShareList())
			{
				System.out.print(sd.getCompanyName() + " " + sd.getShare() + " ");
			}

			System.out.println();
			System.out.println();

			// System.out.println(ad.getYear());
		}

	}
}
