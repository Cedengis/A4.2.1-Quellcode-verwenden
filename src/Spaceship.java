import java.util.ArrayList;
import java.util.Random;

public class Spaceship {
    // Parameter
    String name;
    int torpedo;
    int android;
    int energy;
    int shield;
    int hull;
    int vitalSys;
    ArrayList<Cargo> cargos;
    ArrayList<Log> logs;

    // Constructor
    Spaceship(String name, int torpedo, int android, int energy, int shield, int hull, int vitalSys) {
        this.name = name;
        this.torpedo = torpedo;
        this.android = android;
        this.energy = energy;
        this.shield = shield;
        this.hull = hull;
        this.vitalSys = vitalSys;
        this.cargos = new ArrayList<Cargo>();
        this.logs = new ArrayList<Log>();
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTorpedo() {
        return torpedo;
    }

    public void setTorpedo(int torpedo) {
        this.torpedo = torpedo;
    }

    public int getAndroid() {
        return android;
    }

    public void setAndroid(int android) {
        this.android = android;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getHull() {
        return hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }

    public int getVitalSys() {
        return vitalSys;
    }

    public void setVitalSys(int vitalSys) {
        this.vitalSys = vitalSys;
    }

    // Methods
    public void allParameter() {
        System.out.println(name + "{" +
                "torpedo='" + torpedo + '\'' +
                ", android='" + android + '\'' +
                ", energy='" + energy + '\'' +
                ", shield='" + shield + '\'' +
                ", hull='" + hull + '\'' +
                ", vitalSys='" + vitalSys + '\'' +
                '}');
    } // Gives out all parameter

    public void allCargo() {
        System.out.println(name + "{" + "cargos=" + cargos + '}');
    } // Gives out all Cargo

    public void allLogs() {
        System.out.println(name + "{" + "logs=" + logs + '}');
    } // Gives out all logs

    public void msg(String string) {
        System.out.println(string);
        logs.add(new Log(string));
    } // Message and save in logs

    public void hit(Spaceship target) {
        msg(target.getName() + " was hit!");
        target.setShield(target.getShield() - 50);
        if (target.getShield() < 0) {
            target.setHull(target.getHull() - 50);
            target.setEnergy(target.getEnergy() - 50);
        }
        if (target.getHull() <= 0) {
            target.setVitalSys(0);
            msg(target.getName() + " was destroyed!");
        }
    } // Spaceship was hit

    public void shootTorpedo(Spaceship target) {
        if (torpedo > 0) {
            torpedo -= 1;
            hit(target);
        } else {
            msg("-=*Click*=-");
        }
    } // Shoot a torpedo at a target

    public void shootCanon(Spaceship target) {
        if (energy >= 50) {
            energy -= 50;
            hit(target);
        } else {
            msg("-=*Click*=-");
        }
    } // Shoot the canon at a target

    public void loadTorpedo(int amount) {
        int i = 0;
        boolean found = false;
        for (Cargo cargo : cargos) {
            if (cargo.getName() == "Phototorpedo") {
                found = true;
                break;
            }
            i++;
        }
        if (found) {
            if (amount > cargos.get(i).getAmount()) {
                amount = cargos.get(i).getAmount();
            }
            cargos.get(i).setAmount(cargos.get(i).getAmount() - amount);
            torpedo = amount;
            msg(amount + " Phototorpedo(s) reloaded!");
        }
    } // Loads a torpedo from the Cargo into the canons

    public void purgeCargo() {
        for (int i = 0; i < cargos.size(); i++) {
            if (cargos.get(i).getAmount() == 0) {
                cargos.remove(i);
            }
        }
    } // Clear all empty cargo

    public void useAndroid(int amount, boolean hull, boolean shield) {
        Random random = new Random();
        int randomInt = random.nextInt(0, 100);
        int repairStructures = 0;
        if (amount > android) {
            amount = android;
        }
        if (hull) {
            repairStructures++;
        }
        if (shield) {
            repairStructures++;
        }
        this.hull = randomInt * amount / repairStructures;
    } // Use the androids to repair

}
