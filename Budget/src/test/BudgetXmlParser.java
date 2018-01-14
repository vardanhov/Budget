package test;

import com.thoughtworks.xstream.XStream;

public class BudgetXmlParser {

	public String getXml(BudgetList budgetList) {
		XStream xstream = new XStream();
        xstream.alias("budget", Budget.class);
        xstream.alias("budgets", BudgetList.class);
        return xstream.toXML(budgetList);
	}
}
