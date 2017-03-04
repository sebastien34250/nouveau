import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class LireMidi {
		
	File boucle = 			ChoisirBoucle();		
	Sequence sequence = 	DéfinirSequence(boucle);
	Sequencer sequencer = 	LireSequence(sequence);
	
	
	private File ChoisirBoucle() {
		// Choix du fichier
		String choix = null;
		System.out.println("1=909, 2=dance, 3=pop");
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		if (numero == 1){
			choix = "909kit_01.mid";
		}
		else if (numero ==2){
			choix = "loop.mid";
		}
		else {
			choix ="fpc_Pop_01.mid";
		}
		File boucle = new File(choix);
		return boucle;
	}
	
	private Sequencer LireSequence(Sequence sequence2) {
		// On met la s�quence dans le s�quenceur et on lance le sequenceur
		Sequencer sequencer = null;
		try {
			sequencer = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sequencer.open();
		} catch (MidiUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			sequencer.setSequence(sequence);
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sequencer.start();
		return sequencer;
	}
	
	private Sequence DéfinirSequence(File boucle2) {
		// La s�quence est d�finie par le fichier
		Sequence sequence = null;
		try {
			try {
				sequence = MidiSystem.getSequence(boucle);
			} catch (InvalidMidiDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sequence.getPatchList().toString();
		return sequence;
	}

}
