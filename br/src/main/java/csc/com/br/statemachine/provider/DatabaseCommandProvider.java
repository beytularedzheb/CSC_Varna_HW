package csc.com.br.statemachine.provider;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import csc.com.br.statemachine.contract.ICommand;
import csc.com.br.statemachine.contract.ICommandProvider;
import csc.com.br.statemachine.util.Command;
import csc.com.br.statemachine.util.Identity;
import csc.com.br.util.HibernateUtil;

public class DatabaseCommandProvider implements ICommandProvider {

	@SuppressWarnings("unchecked")
	public List<ICommand> getCommands() {
		Session s = HibernateUtil.getSessionFactory().openSession();
		List<String> stringCommands;
		try {
			if (!s.getTransaction().isActive()) {
				s.getTransaction().begin();
			}
			stringCommands = s.createSQLQuery("select value from command_entries where command_id = :commandEntityX").setParameter("commandEntityX", 1).list();

			if (stringCommands.size() > 0) {
				List<ICommand> result = new ArrayList<ICommand>();
				for (String cee : stringCommands) {
					ICommand c = new Command(new Identity(cee));
					result.add(c);
				}
				return result;
			}
		} catch (RuntimeException re) {
			return null;
		} finally {
			s.close();
		}
		return null;
	}

}
