package pl.jkuznik.computer.software.file.musicfile;

import pl.jkuznik.computer.software.file.FileType;

public class MP3MusicFile extends AbstractMusicFile {
    private int quality;

    public MP3MusicFile(FileType fileType, String name, long size, String bandName, String title, int quality) {
        super(fileType, name, size, bandName, title);
        this.quality = quality;
    }


    public String getBandName(){
        return bandName;
    }

    public String getTitle() {
        return title;
    }

    public int getQuality() {
        return quality;
    }


    @Override
    public void play() {
        System.out.println("Playing MP3 file");
    }

    @Override
    public String toString() {
        return "MP3MusicFile{" +
                "fileType=" + fileType +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", bandName='" + bandName + '\'' +
                ", title='" + title + '\'' +
                ", quality=" + quality +
                '}';
    }
}
