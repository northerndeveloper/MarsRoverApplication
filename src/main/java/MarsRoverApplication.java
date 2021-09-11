import contant.DirectionContants;
import entity.Axis;
import service.MarsRoverService;

public class MarsRoverApplication {

    //TODO logger ekle !!
    //TODO negative case leri de hesapla
    // TODO kullanicidan verileri girmesini iste (optional)
    //REadme dosyasini guncelle mesela java ile nasil calistirilir anlatmaya calis

    private static MarsRoverService marsRoverService = new MarsRoverService();

    public static void main(String args[]) {
        MarsRoverApplication rover = new MarsRoverApplication();
        Axis axis = new Axis(4,2, DirectionContants.East);
        marsRoverService.processCommands("FLFFFRFLB",axis);
        marsRoverService.showDirection(axis); // prints (6,4) North
    }


}
