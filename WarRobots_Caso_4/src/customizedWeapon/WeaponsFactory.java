package customizedWeapon;

import common.robotBase.Weapon;

public class WeaponsFactory {
	private static String packageName = "customizedWeapon.";
	
	public static Weapon create(String pWeapon,int pSpeed, int pLevel, int pAttackDistance) {
		Weapon result = null;

		try {
			String className = packageName+pWeapon;
			result = (Weapon)Class.forName(className).getDeclaredConstructor().newInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			result = new LanzaLlamas(pSpeed,pLevel, pAttackDistance);
		}
		
		return result;
	} 
}
