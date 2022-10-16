package school.baumarkt;

class Rollgestell extends Bauteil
{
    @Override
    public Bauteil getNaechster() {
        return new Rollgestell();
    }

    @Override
    public String buildWerkzeugString(String builder) {
        if(builder.length() >= 2) {
            builder = builder.substring(0, builder.length() - 2);
        }

        return "[" + builder + "]";
    }
}
