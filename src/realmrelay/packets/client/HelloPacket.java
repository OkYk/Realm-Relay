package realmrelay.packets.client;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import realmrelay.packets.Packet;

/* Thanks to Maat and Gratin */

public class HelloPacket extends Packet {
	
	public String buildVersion;
	public int gameId = 0;
	public String guid;
	public int randomInt;
	public String password;
	public String secret;
	public int keyTime = 0;
	public byte[] key = new byte[0];
	public String obf1;
	public String obf2 = "";
	public String obf3 = "";
	public String obf4 = "";
	public String obf5 = "";
	public String obf6 = "";
	
	@Override
	public void parseFromInput(DataInput in) throws IOException {
		
		this.buildVersion = in.readUTF();
		this.gameId = in.readInt();
		this.guid = in.readUTF();
		this.randomInt = in.readInt();
		this.password = in.readUTF();
		this.secret = in.readUTF();
		this.keyTime = in.readInt();
		this.key = new byte[in.readShort()];
		in.readFully(this.key);
		this.obf1 = in.readUTF();
		this.obf2 = in.readUTF();
		this.obf3 = in.readUTF();
		this.obf4 = in.readUTF();
		this.obf5 = in.readUTF();
		this.obf6 = in.readUTF();
		
	}
	
	@Override
	public void writeToOutput(DataOutput out) throws IOException {
		
		out.writeUTF(this.buildVersion);
		out.writeInt(this.gameId);
		out.writeUTF(this.guid);
		out.writeInt(randomInt);
		out.writeUTF(this.password);
		out.writeUTF(this.secret);
		out.writeInt(this.keyTime);
		out.writeShort(this.key.length);
		out.write(this.key);
		out.writeInt(this.obf1.length());
		out.writeBytes(this.obf1);
		out.writeUTF(this.obf2);
		out.writeUTF(this.obf3);
		out.writeUTF(this.obf4);
		out.writeUTF(this.obf5);
		out.writeUTF(this.obf6);
		
	}
}