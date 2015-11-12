
package Domain;

import java.io.Serializable;

public class Reservation implements Serializable{

    private int StartTime;
    private int EndTime;
    private int Identity;

    public Reservation(int StartTime, int EndTime, int Identity) {
        this.SetStartTime(StartTime);
        this.SetEndTime(EndTime);
        this.SetIdentity(Identity);

    }

    public int GetStartTime() {
        return this.StartTime;
    }

    public void SetStartTime(int StartTime) {
        this.StartTime = StartTime;
    }

    public int GetEndTime() {
        return this.EndTime;
    }

    public void SetEndTime(int EndTime) {
        this.EndTime = EndTime;
    }
    
public int GetIdentity() {
        return this.Identity;
    }

    public void SetIdentity(int Identity) {
        this.Identity = Identity;
    }


}
