package me.gavin.gavhax.event.events;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Event;

public class PacketEvent {

    public static class Send extends Event {
        @Override
        public boolean isCancelable() {
            return true;
        }

        private final Packet packet;

        public Send(Packet packetIn) {
            this.packet = packetIn;
        }

        public Packet getPacket() {
            return this.packet;
        }
    }

    public static class Receive extends Event {
        @Override
        public boolean isCancelable() {
            return true;
        }

        private final Packet packet;

        public Receive(Packet packetIn) {
            this.packet = packetIn;
        }

        public Packet getPacket() {
            return this.packet;
        }
    }
}
