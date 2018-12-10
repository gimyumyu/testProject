package ±Ë¿Ø¡§;

import java.util.*;

public class ProgTest2 {
	Map<String, MemberData> mapList = new Hashtable<>();

	void mapListAdd(String memberID, String name, String tel, String gender) {
		mapList.put(memberID, new MemberData(memberID, name, tel, gender));
	}

	void mapListRemove(String memberID) {
		mapList.remove(memberID);
	}

	ArrayList<MemberData> getMapList() {
		ArrayList<MemberData> al = new ArrayList<>();
		Set<String> keyset = mapList.keySet();
		Iterator<String> keyiterator = keyset.iterator();
		while (keyiterator.hasNext()) {
			al.add(mapList.get(keyiterator.next()));
		}
		return al;
	}
}
