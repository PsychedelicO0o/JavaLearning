
    package com.test.dynamics.test.designpattern.lawofdemeter;
    /**
     * 
     * <p>Description: [一个软件实体应当尽可能少的与其他实体发生相互作用。每一个软件单位对其他的单位都只有最少的知识，而且局限于那些与本单位密切相关的软件单位。
						迪米特法则的初衷在于降低类之间的耦合。由于每个类尽量减少对其他类的依赖，因此，很容易使得系统的功能模块功能独立，相互之间不存在（或很少有）依赖关系。
						迪米特法则不希望类直接建立直接的接触。如果真的有需要建立联系，也希望能通过它的友元类来转达。
						因此，应用迪米特法则有可能造成的一个后果就是：系统中存在大量的中介类，这些类之所以存在完全是为了传递类之间的相互调用关系——这在一定程度上增加了系统的复杂度]</p> 
     * @category 迪米特法则（最少知识原则）
     * @author BlueWind
     * @version $Revision$ 2014年8月20日
     * @author (lastest modification by $Author$)
     * @since 1.0
     */
    public class LawofDemeterTest {
    	
    	static class Person{
    		public String name;
    	}
    	static class Killer{
    		public void kill(String name){
    			System.out.println(name+"被杀死了");
    		}
    	}
    	static class CoreMember{
    		Killer killer = new Killer();
    		public void kill(String name){
    			killer.kill(name);
    		}
    	}
    	static class Father{
    		CoreMember coreMember = new CoreMember();
    		public  void kill(String name){
    			coreMember.kill(name);
    		}
    	}

    	public static void main(String[] args){
    		new Father().kill("张三");
    	}

}

  