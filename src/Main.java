public class Main {
    public static void main(String[] args) {
        Spaceship klingone = new Spaceship("IKS Hegh´ta", 0, 2, 100, 100, 100, 100);
        Spaceship romulans = new Spaceship("IRW Khazara", 2, 2, 50, 100, 100, 100);
        Spaceship vulkan = new Spaceship("Ni´Var", 0, 5, 80, 80, 50, 100);

        klingone.cargos.add(new Cargo("Ferengi Slug-juice", 200));
        klingone.cargos.add(new Cargo("Bat´leth klingone sword", 200));

        romulans.cargos.add(new Cargo("Borg-scrap", 5));
        romulans.cargos.add(new Cargo("Red matter", 2));
        romulans.cargos.add(new Cargo("Plasma-gun", 50));

        vulkan.cargos.add(new Cargo("Research-drone", 35));
        vulkan.cargos.add(new Cargo("Phototorpedo", 3));

        // Die Klingonen schießen mit dem Photonentorpedo einmal auf die Romulaner.
        klingone.shootTorpedo(romulans);
        // Die Romulaner schießen mit der Phaserkanone zurück.
        romulans.shootCanon(klingone);
        // Die Vulkanier senden eine Nachricht an Alle “Gewalt ist nicht logisch".
        vulkan.msg("Violence is not logical.");
        // Die Klingonen rufen den Zustand Ihres Raumschiffes ab und geben Ihr Ladungsverzeichnis aus
        klingone.allParameter();
        klingone.allCargo();
        // Die Vulkanier sind sehr sicherheitsbewusst und setzen alle Androiden zur Aufwertung ihres Schiffes ein.
        vulkan.useAndroid(100, true, true);
        // Die Vulkanier verladen Ihre Ladung “Photonentorpedos” in die Torpedoröhren Ihres Raumschiffes und räumen das Ladungsverzeichnis auf.
        vulkan.loadTorpedo(100);
        vulkan.purgeCargo();
        // Die Klingonen schießen mit zwei weiteren Photonentorpedo auf die Romulaner.
        klingone.shootTorpedo(romulans);
        klingone.shootTorpedo(romulans);
        // Die Klingonen, die Romulaner und die Vulkanier rufen jeweils den Zustand Ihres Raumschiffes ab und geben Ihr Ladungsverzeichnis aus.
        klingone.allParameter();
        klingone.allCargo();
        romulans.allParameter();
        romulans.allCargo();
        vulkan.allParameter();
        vulkan.allCargo();

        // Geben Sie den broadcastKommunikator aus.
        klingone.allLogs();
        romulans.allLogs();
        vulkan.allLogs();
    }
}
