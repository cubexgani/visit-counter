import { useState, useEffect } from "react";
import { Card, CardContent, CardFooter, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";

const COUNTER_KEY = "visitor-counter";
const LAST_VISIT_KEY = "visitor-last-visit";
const API_BASE_URL = import.meta.env.VITE_API_BASE_URL;

const Index = () => {
  const [count, setCount] = useState(0);
  const [lastVisit, setLastVisit] = useState<string | null>(null);

  // 1. Function to handle the increment (called on page load)
  const incrementVisitor = async () => {
    try {
      const response = await fetch(`${API_BASE_URL}/increment`, {
        method: 'POST'
      });
      const data = await response.json(); // data is { count, lastVisited }
      
      setCount(data.count);
      // Format the date string for display
      setLastVisit(data.lastVisited ? new Date(data.lastVisited).toLocaleString() : "Never");
    } catch (error) {
      console.error("Failed to increment counter:", error);
    }
  };

  useEffect(() => {
    incrementVisitor();
  }, []);

  // 2. Function to handle the reset
  const handleReset = async () => {
    try {
      const response = await fetch(`${API_BASE_URL}/reset`, {
        method: 'POST'
      });
      const data = await response.json();
      
      setCount(data.count);
      setLastVisit(null);
    } catch (error) {
      console.error("Failed to reset counter:", error);
    }
  };

  const displayCount = String(count).padStart(7, "0");

  return (
    <div className="flex min-h-screen items-center justify-center bg-background p-4">
      <Card className="w-full max-w-md border-2 border-border shadow-none">
        <CardHeader className="text-center">
          <CardTitle className="text-xl tracking-wide text-foreground">
            Visitor Counter
          </CardTitle>
        </CardHeader>
        <CardContent className="flex flex-col items-center gap-6">
          <p className="text-sm text-muted-foreground">You are visitor</p>
          <div className="border-2 border-border bg-background px-8 py-4">
            <span className="text-4xl font-bold tracking-widest text-primary">
              #{displayCount}
            </span>
          </div>
          <Button
            variant="outline"
            onClick={handleReset}
            className="border-2 border-primary text-primary hover:bg-primary hover:text-primary-foreground"
          >
            Reset Counter
          </Button>
        </CardContent>
        <CardFooter className="justify-center">
          <p className="text-xs text-muted-foreground">
            {lastVisit ? `Last visit: ${lastVisit}` : "Welcome, first-time visitor!"}
          </p>
        </CardFooter>
      </Card>
    </div>
  );
};

export default Index;
