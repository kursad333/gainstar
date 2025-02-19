import type {MuscleGroup} from "@/model/MuscleGroup.ts";

class SessionService {
    public getAllMuscleGroups(): Promise<MuscleGroup[]> {
        return new Promise<any>((resolve, reject) => {
            fetch('http://localhost:8080/api/power/musclegroups', {
                method: "GET",
                credentials: "include", // Required when allowCredentials is true
                headers: {
                    "Content-Type": "application/json"
                }
            })
                .then(res => {
                    console.log(res);
                    return res.json()
                })
                .catch(reject);
        });
    }
}

export const sessionService: SessionService = new SessionService();