package com.officetools.frontmattercomparisontool;

import com.officetools.frontmattercomparisontool.models.TocSearchItem;

public class client {
    public static void main(String[] args) {
        String[] output = new String[] {"Add Revbar for {DESCRIPTION AND OPERATION} <11> (Detailed Theory) Page number got changed from 128 to 127",
                "Add Revbar for {DESCRIPTION AND OPERATION} <11> (Detailed Theory) |A| [Digital Instrumentation A1] Page number got changed from 128 to 127",
                "Add Revbar for {DESCRIPTION AND OPERATION} <11> (Detailed Theory) |B| [RF Translator A2] Page number got changed from 169 to 167",
                "Add Revbar for {DESCRIPTION AND OPERATION} <11> (Detailed Theory) |C| [Audio/Interface A3] Page number got changed from 179 to 177",
                "Add Revbar for {DESCRIPTION AND OPERATION} <11> (Detailed Theory) |D| [Transmitter Power Output and Control Circuits] Page number got changed from 195 to 193",
                "Add Revbar for {DESCRIPTION AND OPERATION} <11> (Detailed Theory) |E| [RF Power Output Circuits] Page number got changed from 195 to 193",
                "Add Revbar for {DESCRIPTION AND OPERATION} <11> (Detailed Theory) |F| [Low-Pass Filter Operation] Page number got changed from 197 to 195",
                "Add Revbar for {DESCRIPTION AND OPERATION} <11> (Detailed Theory) |G| [Power Amplifier Control Circuits] Page number got changed from 200 to 198"};
        for(int i=0; i< output.length; i++){
            System.out.println(TocSearchItem.extractTocSearchItems(output[i]));
        }
    }
}
