class PouringState
{
    int capacityA;
    int capacityB;
    int valueA;
    int valueB;

    public PouringState(int ca, int cb, int va, int vb)
    {
        this.capacityA = ca;
        this.capacityB = cb;
        this.valueA = va;
        this.valueB = vb;
    }

    public PouringState fillA()
    {
        return new PouringState(this.capacityA, this.capacityB, this.capacityA, this.valueB);
    }

    public PouringState fillB()
    {
        return new PouringState(this.capacityA, this.capacityB, this.valueA, this.capacityB);
    }

    public PouringState aToB()
    {
        int newA, newB;
        if (this.valueA + this.valueB > this.capacityB)
        {
            newA = this.valueA - (this.capacityB - this.valueB);
            newB = capacityB;
        }
        else
        {
            newA = 0;
            newB = this.valueA + this.valueB;
        }
        return new PouringState(this.capacityA, this.capacityB, newA, newB);
    }

    public PouringState bToA()
    {
        int newA, newB;
        if (this.valueA + this.valueB > this.capacityA)
        {
            newB = this.valueB - (this.capacityA - this.valueA);
            newA = capacityA;
        }
        else
        {
            newB = 0;
            newA = this.valueA + this.valueB;
        }
        return new PouringState(this.capacityA, this.capacityB, newA, newB);
    }
}
